#include <windows.h>
#include <stdio.h>
#include <jni.h>
#include <windows.h>

typedef jint (JNICALL CreateJavaVM_t)(JavaVM **pvm, void **env, void *args);

JavaVM* jvm;

JNIEnv* create_vm() {
	JNIEnv* env;
	JavaVMInitArgs args;
	JavaVMOption options[1];
	int retval = 0;
	CreateJavaVM_t *CreateJavaVM;

	HINSTANCE handle;

	/* Load the Java VM DLL */
	if ((handle = LoadLibrary(L"jre\\bin\\server\\jvm.dll")) == NULL)
	{
		MessageBoxEx(NULL, L"Erro: Não pude ler o JVM", L"Html Help Editor 1.0", MB_OK, 0);
		return NULL;
	}

	/* Now get the function addresses */
	CreateJavaVM = (CreateJavaVM_t *)GetProcAddress(handle, "JNI_CreateJavaVM");
	if (CreateJavaVM == NULL)
	{
		MessageBoxEx(NULL, L"Erro: Não pude encontrar uma interface JNI", L"Html Help Editor 1.0", MB_OK, 0);
		return NULL;
	}
	args.version = JNI_VERSION_1_2;
	args.nOptions = 1;
	options[0].optionString = "-Djava.class.path=.;HtmlHelpEditor.jar";
	args.options = options;
	args.ignoreUnrecognized = JNI_FALSE;
	retval = CreateJavaVM(&jvm, (void **)&env, &args);
	if(retval != 0)
	{
		MessageBoxEx(NULL, L"Erro: Não pude criar o JVM", L"Html Help Editor 1.0", MB_OK, 0);
		return NULL;
	}

	return env;
}

void invoke_class(JNIEnv* env) {
	jclass myClass;
	jmethodID mainMethod;
	jobjectArray applicationArgs;
	jstring applicationArg0 = NULL;

	if(env == NULL) return;

	myClass = (*env)->FindClass(env, "htmlhelpeditor/Application");
	if(myClass == NULL)
	{
		MessageBoxEx(NULL, L"Não consegui encontrar a classe", L"Html Help Editor 1.0", MB_OK, 0);
		return;
	}
	mainMethod = (*env)->GetStaticMethodID(env, myClass, "main", "([Ljava/lang/String;)V");
	if(mainMethod == NULL)
	{
		MessageBoxEx(NULL, L"Método main não encontrado", L"Html Help Editor 1.0", MB_OK, 0);
		return;
	}
	applicationArgs = (*env)->NewObjectArray(env, 0, (*env)->FindClass(env, "java/lang/String"), NULL);
	//applicationArg0 = (*env)->NewStringUTF(env, "From-C-program");
	//(*env)->SetObjectArrayElement(env, applicationArgs, 0, applicationArg0);
	(*env)->CallStaticVoidMethod(env, myClass, mainMethod, applicationArgs);

	(*jvm)->DestroyJavaVM(jvm);
}

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance,
    LPSTR lpCmdLine, int nCmdShow)
{
    JNIEnv* env = create_vm();
	invoke_class( env );
    return 0;
}
