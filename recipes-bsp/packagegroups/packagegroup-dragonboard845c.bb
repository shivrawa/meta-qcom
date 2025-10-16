SUMMARY = "Packages for the DragonBoard 845c board"

inherit packagegroup

PACKAGES = " \
    ${PN}-firmware \
    ${PN}-hexagon-dsp-binaries \
"

RRECOMMENDS:${PN}-firmware = " \
    ${@bb.utils.contains_any('DISTRO_FEATURES', 'opencl opengl vulkan', 'linux-firmware-qcom-adreno-a630 linux-firmware-qcom-sdm845-adreno', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'linux-firmware-ath10k-wcn3990 linux-firmware-qcom-sdm845-modem', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'bluetooth', 'linux-firmware-qca-wcn399x linux-firmware-qcom-sdm845-modem', '', d)} \
    linux-firmware-qcom-sdm845-audio \
    linux-firmware-qcom-sdm845-compute \
    linux-firmware-qcom-sdm845-thundercomm-db845c-sensors \
    linux-firmware-qcom-venus-5.2 \
"

RRECOMMENDS:${PN}-hexagon-dsp-binaries = " \
    hexagon-dsp-binaries-thundercomm-db845c-adsp \
    hexagon-dsp-binaries-thundercomm-db845c-cdsp \
    hexagon-dsp-binaries-thundercomm-db845c-sdsp \
"
