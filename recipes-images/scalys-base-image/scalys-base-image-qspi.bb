SUMMARY = "Scalys image for a small internal on-board MTD"
DESCRIPTION = ""
LICENSE = "GPLV2"
LIC_FILES_CHKSUM = ""


require scalys-base-image.inc

IMAGE_FSTYPES = "wic tar.gz ubi ubifs"

IMAGE_INSTALL += "\
"

IMAGE_FEATURES += "read-only-rootfs"
