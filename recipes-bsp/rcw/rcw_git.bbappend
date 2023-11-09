FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

BOARD_TARGETS:qls1046-4gb-dkb = "qls1046a-4gb"
BOARD_TARGETS:qls1046-4gb-dk  = "qls1046a-4gb"

SRC_URI += "file://0001-Added-support-for-qls1046a4gb.patch"
