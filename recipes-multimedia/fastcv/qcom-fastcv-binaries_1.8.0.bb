SUMMARY = "Optimized Qualcomm FastCV library for Image Processing and Computer Vision"
DESCRIPTION = "Qualcomm FastCV userspace library supporting Image Processing and Computer Vision applications"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://${UNPACKDIR}/usr/share/doc/${PN}/NOLOGINBINARYLICENSEQTI.pdf;md5=4ceffe94cb40cdce6d2f4fb93cc063d1 \
                    file://${UNPACKDIR}/usr/share/doc/${PN}/NOTICE;md5=4b722aa0574e24873e07b94e40b92e4d "

PBT_BUILD_DATE = "250826"
ARTIFACTORY_URL = "https://qartifactory-edge.qualcomm.com/artifactory/qsc_releases/software/chip/component/computervision-fastcv.qclinux.0.1/${PBT_BUILD_DATE}/prebuilt_yocto"
PBT_ARCH = "armv8a"

SRC_URI = "${ARTIFACTORY_URL}/${BPN}_${PV}_${PBT_ARCH}.tar.gz"
SRC_URI[sha256sum] = "a2805bfb2ef177211849eec2184abd4e6821cd5e441c928598b199b26abcb8fd"
S = "${UNPACKDIR}"

RDEPENDS:${PN} += "glib-2.0"

# This package is currently only used and tested on ARMv8 (aarch64) machines.
# Therefore, builds for other architectures are not necessary and are explicitly excluded.
COMPATIBLE_MACHINE = "^$"
COMPATIBLE_MACHINE:aarch64 = "(.*)"

do_install() {
    install -d ${D}${libdir}/pkgconfig
    install -d ${D}${datadir}/doc/${PN}
    install -d ${D}${includedir}/fastcv

    install -m 0755 ${S}/usr/lib/libfastcvopt.so.1.8.0 ${D}${libdir}
    cp -d ${S}/usr/lib/libfastcvopt.so.1 ${D}${libdir}
    cp -d ${S}/usr/lib/libfastcvopt.so ${D}${libdir}

    install -m 0644 ${S}/usr/lib/pkgconfig/qcom-fastcv-binaries.pc ${D}${libdir}/pkgconfig/
    install -m 0644 ${S}/usr/share/doc/${PN}/NOTICE ${D}${datadir}/doc/${PN}
    install -m 0644 ${S}/usr/share/doc/${PN}/NOLOGINBINARYLICENSEQTI.pdf ${D}${datadir}/doc/${PN}
    install -m 0644 ${S}/usr/include/fastcv/fastcv.h ${D}${includedir}/fastcv/
    install -m 0644 ${S}/usr/include/fastcv/fastcvExt.h ${D}${includedir}/fastcv/
}
