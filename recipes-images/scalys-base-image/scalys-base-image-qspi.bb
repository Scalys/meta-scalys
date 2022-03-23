SUMMARY = "Scalys image for a small internal on-board MTD"
DESCRIPTION = ""
LICENSE = "GPLV2"
LIC_FILES_CHKSUM = ""


require scalys-base-image.inc

IMAGE_FSTYPES = "tar.gz ubi ubifs"

IMAGE_INSTALL += "\
	u-boot-qspi-boot \
"

IMAGE_FEATURES += "read-only-rootfs"
