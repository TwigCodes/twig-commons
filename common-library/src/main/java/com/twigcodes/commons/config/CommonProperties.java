package com.twigcodes.commons.config;

import com.twigcodes.commons.Constants;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "commons")
public class CommonProperties {

    private OAuth2 oAuth2 = new OAuth2();
    private SwaggerApiInfo swaggerApiInfo = new SwaggerApiInfo();

    public OAuth2 getOAuth2() {
        return oAuth2;
    }

    public void setOAuth2(OAuth2 oAuth2) {
        this.oAuth2 = oAuth2;
    }

    public SwaggerApiInfo getSwaggerApiInfo() {
        return swaggerApiInfo;
    }

    public void setSwaggerApiInfo(SwaggerApiInfo swaggerApiInfo) {
        this.swaggerApiInfo = swaggerApiInfo;
    }

    public static class OAuth2 {
        private String serverUrl = "https://auth.twigcodes.com/auth/realms";
        private String realm = "twigcodes";
        private String clientId = "login-app";
        private String clientSecret = "b888bb5b-2627-453e-b3a7-2fb79c923032";

        public String getServerUrl() {
            return serverUrl;
        }

        public void setServerUrl(String serverUrl) {
            this.serverUrl = serverUrl;
        }

        public String getRealm() {
            return this.realm;
        }

        public void setRealm(String realm) {
            this.realm = realm;
        }

        public String getAuthorizeUrl() {
            return serverUrl + "/" + realm + "/protocol/openid-connect/auth";
        }

        /**
         * @return the tokenUrl
         */
        public String getTokenUrl() {
            return serverUrl + realm + "/protocol/openid-connect/token";
        }

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public String getClientSecret() {
            return clientSecret;
        }

        public void setClientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
        }
    }

    public static class SwaggerApiInfo {

        private String scanPackages = Constants.BASE_PACKAGE_NAME;
        private String title = "推码科技交互式文档";
        private String description = "基于 Rest 标准定义的 API 接口，供 Android， iOS 和 Web 客户端调用";
        private String version = "1.0";
        private String termsOfServiceUrl = "http://www.twigcodes.com/apicube/tos.html";
        private String license = "API 授权协议";
        private String licenseUrl = "http://www.twigcodes.com/smartoffice/api-license.html";
        private Contact contact = new Contact();

        public Contact getContact() {
            return contact;
        }

        public void setContact(Contact contact) {
            this.contact = contact;
        }

        public String getScanPackages() {
            return scanPackages;
        }

        public void setScanPackages(String scanPackages) {
            this.scanPackages = scanPackages;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getTermsOfServiceUrl() {
            return termsOfServiceUrl;
        }

        public void setTermsOfServiceUrl(String termsOfServiceUrl) {
            this.termsOfServiceUrl = termsOfServiceUrl;
        }

        public String getLicense() {
            return license;
        }

        public void setLicense(String license) {
            this.license = license;
        }

        public String getLicenseUrl() {
            return licenseUrl;
        }

        public void setLicenseUrl(String licenseUrl) {
            this.licenseUrl = licenseUrl;
        }


        public static class Contact {
            private String name = "推码科技";
            private String url = "http://www.twigcodes.com";
            private String email = "wangpeng@twigcodes.com";

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }
        }
    }
}
