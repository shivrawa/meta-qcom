DESCRIPTION = "QCOM Iris Video Driver"
LICENSE = "GPL-2.0-only"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

PV = "0.0+git"

SRC_URI = "git://github.com/qualcomm-linux/video-driver.git;protocol=https;branch=video.qclinux.0.0"
SRCREV  = "170ac561d70a366bc6502810079fa6b6c914920d"

inherit module

MAKE_TARGETS = "modules"

# This package is designed to run exclusively on ARMv8 (aarch64) machines.
# Therefore, builds for other architectures are not necessary and are explicitly excluded.
COMPATIBLE_MACHINE = "^$"
COMPATIBLE_MACHINE:aarch64 = "(.*)"
