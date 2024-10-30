package com.epam.rd.contactbook;

public class Contact {
    private String name;
    private ContactInfo phoneNumberInfo;
    private final int emailAmount = 3;
    private ContactInfo[] emailsInfo = new Email[emailAmount];
    private int emailCount = 0;
    private final int socialAmount = 5;
    private ContactInfo[] socialMediaInfo = new Social[socialAmount];
    private int socialCount = 0;

    public Contact(String contactName) {
        if (contactName == null || contactName.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = contactName;
    }

    public void rename(String newName) {
        if (newName == null || newName.isEmpty()) {
            return;
        }
        this.name = newName;
    }

    public Email addEmail(String localPart, String domain) {
        Email email = null;
        if (emailCount<emailAmount){
            email = new Email(localPart, domain);
            emailsInfo[emailCount++] = email;
        }
        return email;
    }


    public Email addEpamEmail(String firstname, String lastname) {
        Email email = null;
        if (emailCount<emailAmount){
            email = new Email(firstname + "_" + lastname, "epam.com") {
                @Override
                public String getTitle() {
                    return "Epam Email";
                }
            };
            emailsInfo[emailCount++] = email;
        }
        return email;
    }

    public ContactInfo addPhoneNumber(int code, String number) {
        if (phoneNumberInfo != null) return null;
        String phoneNumber = "+" + code + " " + number;
        phoneNumberInfo = new ContactInfo() {
            @Override
            public String getTitle() {
                return "Tel";
            }

            @Override
            public String getValue() {
                return phoneNumber;
            }
        };
        return phoneNumberInfo;
    }

    public Social addTwitter(String twitterId) {
        Social social = null;
        if (socialCount<socialAmount){
            social = new Social("Twitter",twitterId);
            socialMediaInfo[socialCount++]= social;
        }
        return social;
    }

    public Social addInstagram(String instagramId) {
        Social social = null;
        if (socialCount<socialAmount){
            social = new Social("Instagram",instagramId);
            socialMediaInfo[socialCount++]= social;
        }
        return social;
    }

    public Social addSocialMedia(String title, String id) {
        Social social = null;
        if (socialCount<socialAmount){
            social = new Social(title,id);
            socialMediaInfo[socialCount++]= social;
        }
        return social;
    }

    public ContactInfo[] getInfo() {
        int infoSize = 1 + (phoneNumberInfo != null ? 1 : 0) + emailCount + socialCount;
        ContactInfo[] info = new ContactInfo[infoSize];
        int index = 0;
        info[index++] = new NameContactInfo();

        if (phoneNumberInfo != null) {
            info[index++] = phoneNumberInfo;
        }

        for (int i = 0; i < emailCount; i++) {
            info[index++] = emailsInfo[i];
        }

        for (int i = 0; i < socialCount; i++) {
            info[index++] = socialMediaInfo[i];
        }

        return info;
    }
    public static class Email implements ContactInfo {
        private final String localPart;
        private final String domain;

        public Email(String localPart, String domain) {
            this.localPart = localPart;
            this.domain = domain;
        }

        @Override
        public String getTitle() {
            return "Email";
        }

        @Override
        public String getValue() {
            return localPart + "@" + domain;
        }
    }

    private class NameContactInfo implements ContactInfo {
        @Override
        public String getTitle() {
            return "Name";
        }

        @Override
        public String getValue() {
            return name;
        }
    }
    public static class Social implements ContactInfo{
        private final String title;
        private final String id;
        public Social(String title, String id) {
            this.title = title;
            this.id = id;
        }
        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getValue() {
            return id;
        }
    }

}
