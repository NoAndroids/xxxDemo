package com.example.retrofitdemo;

import java.util.List;

/**
 * Created by Administrator on 2016/7/22.
 */
public class Bean {

    @Override
    public String toString() {
        return "Bean{" +
                "data=" + data +
                ", msg='" + msg + '\'' +
                ", statecode='" + statecode + '\'' +
                ", success=" + success +
                '}';
    }

    /**
     * accid : 4505
     * id : 4505
     * organizationId : 148
     * phone : 17731392092
     * qrCode : 4505.png
     * roles : [{"code":"ROLE_AGENT","id":2,"name":"代理人"},{"code":"ROLE_NORMAL","id":5,"name":"普通用户"}]
     * status : 1
     * token : eJxFkFFrgzAUhf*Lrx0jMYmzgz2oKJWtirZleQuZRsm0Gkxa7Mb**1yo7PX7uJxz7rdzfDs8cqVkzbhhaKqdZwc4DxaLWclJMN4YMS3YJVsXgFVexaTlOPxxAAl0EQD-UtZiMLKR9g4TQO5cy3YB*-gUpUXUeVua3bJc0pwGXulrHFLuS8*YLnn9oEWGr00bI-pZBGmbFzo64OprxoE76h7vwz4pSXDZbKIxCVP6vjvt*hmWZxW-rGF1x*yyJRLipRyEmKC7NPIsLPd8BAF5Wpvzqhovg2HmpoR9xc8v8pdVVA__
     * username : 17731392092
     * yxName : 尚宏宇
     */

    private DataBean data;
    /**
     * data : {"accid":"4505","id":4505,"organizationId":"148","phone":"17731392092","qrCode":"4505.png","roles":[{"code":"ROLE_AGENT","id":2,"name":"代理人"},{"code":"ROLE_NORMAL","id":5,"name":"普通用户"}],"status":1,"token":"eJxFkFFrgzAUhf*Lrx0jMYmzgz2oKJWtirZleQuZRsm0Gkxa7Mb**1yo7PX7uJxz7rdzfDs8cqVkzbhhaKqdZwc4DxaLWclJMN4YMS3YJVsXgFVexaTlOPxxAAl0EQD-UtZiMLKR9g4TQO5cy3YB*-gUpUXUeVua3bJc0pwGXulrHFLuS8*YLnn9oEWGr00bI-pZBGmbFzo64OprxoE76h7vwz4pSXDZbKIxCVP6vjvt*hmWZxW-rGF1x*yyJRLipRyEmKC7NPIsLPd8BAF5Wpvzqhovg2HmpoR9xc8v8pdVVA__","username":"17731392092","yxName":"尚宏宇"}
     * msg :
     * statecode : 0
     * success : true
     */

    private String msg;
    private String statecode;
    private boolean success;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatecode() {
        return statecode;
    }

    public void setStatecode(String statecode) {
        this.statecode = statecode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DataBean {
        private String accid;
        private int id;
        private String organizationId;
        private String phone;
        private String qrCode;
        private int status;
        private String token;
        private String username;
        private String yxName;
        /**
         * code : ROLE_AGENT
         * id : 2
         * name : 代理人
         */

        private List<RolesBean> roles;

        public String getAccid() {
            return accid;
        }

        public void setAccid(String accid) {
            this.accid = accid;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOrganizationId() {
            return organizationId;
        }

        public void setOrganizationId(String organizationId) {
            this.organizationId = organizationId;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getQrCode() {
            return qrCode;
        }

        public void setQrCode(String qrCode) {
            this.qrCode = qrCode;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getYxName() {
            return yxName;
        }

        public void setYxName(String yxName) {
            this.yxName = yxName;
        }

        public List<RolesBean> getRoles() {
            return roles;
        }

        public void setRoles(List<RolesBean> roles) {
            this.roles = roles;
        }

        public static class RolesBean {
            private String code;
            private int id;
            private String name;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }


    }
}
