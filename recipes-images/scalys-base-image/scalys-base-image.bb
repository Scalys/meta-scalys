SUMMARY = "Scalys image for a SD cards. Can be used on USB/SATA with updated boot script"
DESCRIPTION = ""
LICENSE = "GPLV2"
LIC_FILES_CHKSUM = ""


require scalys-base-image.inc

WKS_FILE = "${MACHINE}-sdimg.wks"

IMAGE_FSTYPES = "wic tar.gz ext2.gz"

IMAGE_INSTALL += "\
    optee-test-qoriq \
    u-boot-mmc-boot \
    composite-firmware \
"

TOOLCHAIN_HOST_TASK += "nativesdk-cmake"
