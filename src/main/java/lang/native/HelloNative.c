#include <stdio.h>
#include "HelloNative.h"

JNIEXPORT void JNICALL Java_HelloNative_sayHello (JNIEnv *env, jclass jclass) {
    printf("Hello from native\n");
}
