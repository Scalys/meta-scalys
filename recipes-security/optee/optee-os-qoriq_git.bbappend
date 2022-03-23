LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=c1f21c4f72f372ef38a5a4aee55ec173"

DEPENDS += "python3-pyelftools-native"


SRCREV = "e2d570599f761dd2a3b05ce315b317888504b39c"
SRC_URI = "gitsm://github.com/ms-iot/optee_os.git;protocol=https;branch=ms-iot-openenclave-3.6.0 \
           file://0001-allow-setting-sysroot-for-libgcc-lookup.patch \
           file://0001-use-python3-instead-of-python.patch \
          "
OPTEEMACHINE_trustbox-edge-101 = "ls1012grapeboard"

