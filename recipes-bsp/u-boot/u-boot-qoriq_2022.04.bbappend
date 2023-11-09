FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://0001-Added-support-for-qls1046a4gb.patch"
SRC_URI:append:qls1046-4gb-dk = " file://0002-SDHC-50MHz.patch"

