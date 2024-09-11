package EntityClass;

import java.util.Date;

/**
 *
 * @author nguye
 */
public class Providers {

    int providersID;
    String providersName;
    String phoneNumber;
    String addressProviders;
    Date contractDate;
    String email;
    String moreInfo;

    public Providers() {
    }

    public Providers(int providersID, String providersName, String phoneNumber, String addressProviders, Date contractDate, String email, String moreInfo) {
        this.providersID = providersID;
        this.providersName = providersName;
        this.phoneNumber = phoneNumber;
        this.addressProviders = addressProviders;
        this.contractDate = contractDate;
        this.email = email;
        this.moreInfo = moreInfo;
    }

    public int getProvidersID() {
        return providersID;
    }

    public void setProvidersID(int providersID) {
        this.providersID = providersID;
    }

    public String getProvidersName() {
        return providersName;
    }

    public void setProvidersName(String providersName) {
        this.providersName = providersName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddressProviders() {
        return addressProviders;
    }

    public void setAddressProviders(String addressProviders) {
        this.addressProviders = addressProviders;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    @Override
    public String toString() {
        return this.providersName + " (" + "ID: " + this.providersID + ") ";
    }

}
