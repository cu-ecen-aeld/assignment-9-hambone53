# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://git@github.com/cu-ecen-aeld/assignment-7-hambone53.git;protocol=ssh;branch=main \
            file://scull_start_stop \
            "

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "d6505a7f1d8846a28c83511e1bebb475e603e21d"

SRC_URI:append = " file://0001-modifying-to-make-just-the-module-for-this-recipe.patch"

S = "${WORKDIR}/git"

inherit module

EXTRA_OEMAKE:append:task-install = " -C ${STAGING_KERNEL_DIR} M=${S}/scull"
EXTRA_OEMAKE += "KERNELDIR=${STAGING_KERNEL_DIR}"

inherit update-rc.d
INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME:${PN} = "scull_start_stop"

FILES:${PN} += "/etc/init.d/*"

do_install () {
    install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/scull_start_stop ${D}${sysconfdir}/init.d
    install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/
    install -m 0755 ${S}/scull/scull.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/
}

