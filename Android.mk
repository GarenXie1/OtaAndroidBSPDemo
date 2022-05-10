LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional

LOCAL_SRC_FILES := $(call all-java-files-under,  app/src/main/java)

LOCAL_PACKAGE_NAME := OtaHR40

LOCAL_SDK_VERSION := current

LOCAL_CERTIFICATE := platform

LOCAL_USE_AAPT2 := true

# 指定Manifest文件
LOCAL_MANIFEST_FILE := app/src/main/AndroidManifest.xml

LOCAL_RESOURCE_DIR := \
	$(addprefix $(LOCAL_PATH)/, app/src/main/res) \



# 重复资源自动覆盖
LOCAL_AAPT_FLAGS += \
     --auto-add-overlay \



include $(BUILD_PACKAGE)