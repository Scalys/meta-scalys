LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "6.1.36"

KERNEL_BRANCH ?= "lf-6.1.y"
KERNEL_SRC ?= "git://github.com/nxp-qoriq/linux.git;protocol=https"
SRC_URI = "${KERNEL_SRC};branch=${KERNEL_BRANCH} \
           file://0001-Added-qls1046a-DTS-files.patch \
"
SRC_URI:append:qls1046-4gb-dk = "file://0002-SDHC-50MHz.patch"

SRCREV = "04b05c5527e9af8d81254638c307df07dc9a5dd3"

DELTA_KERNEL_DEFCONFIG:append:qls1046a-4gb = " qls1046a-4gb.config"

require recipes-kernel/linux/linux-qoriq.inc

