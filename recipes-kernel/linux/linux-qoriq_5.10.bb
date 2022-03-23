LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION = "5.10.52"

SRC_URI = "git://github.com/Scalys/linux-qoriq.git;protocol=git;nobranch=1"
SRCREV = "22edeb64a8bf2e7d8b8daec6b8d6d2681afa42b6"

require recipes-kernel/linux/linux-qoriq.inc

deltask merge_delta_config
addtask merge_delta_config before do_kernel_localversion after do_patch

DELTA_KERNEL_DEFCONFIG = "trustbox.config lsdk.conf "

