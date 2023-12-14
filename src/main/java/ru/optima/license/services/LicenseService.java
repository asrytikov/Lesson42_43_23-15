package ru.optima.license.services;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.optima.license.model.License;

import java.util.Locale;
import java.util.Random;

@Service
public class LicenseService {

    public final MessageSource messages;

    public LicenseService(MessageSource messages) {
        this.messages = messages;
    }

    public String createLicense(License license, String organizationId, Locale locale){
        String responseMessage = null;
        if (license != null){
            license.setOrganizationId(organizationId);
            responseMessage = String.format(messages.getMessage("license.create.message", null, locale), license.toString());
        }
        return responseMessage;
    }

    public License getLicense(String licenseId, String organizationId){
        License license = new License();
        license.setId(new Random().nextInt(1000));
        license.setLicenseId(licenseId);
        license.setOrganizationId(organizationId);
        license.setDescription("Software");
        license.setProductName("Optima");
        license.setLicenseType("Full");
        return license;
    }

    public String updateLicense(License license, String organizationId, Locale locale) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            responseMessage = String.format(messages.getMessage("license.update.message", null, locale), license.toString());
        }
        return responseMessage;
    }

    public String deleteLicense(String licenseId, String organizationId, Locale locale){
        return String.format(messages.getMessage("license.delete.message", null, locale), licenseId, organizationId);
    }
}
