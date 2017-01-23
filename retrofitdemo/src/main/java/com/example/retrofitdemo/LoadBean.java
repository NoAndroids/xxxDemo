package com.example.retrofitdemo;

import java.util.List;

/**
 * Created by Administrator on 2016/7/22.
 */
public class LoadBean {
    @Override
    public String toString() {
        return "LoadBean{" +
                "msg='" + msg + '\'' +
                ", statecode='" + statecode + '\'' +
                ", success=" + success +
                ", data=" + data +
                '}';
    }

    /**
     * data : [{"id":1,"level":2,"name":"河北省","pId":3},{"id":3,"level":1,"name":"平台","pId":0},{"id":134,"level":3,"name":"石家庄市","pId":1},{"id":135,"level":4,"name":"裕华区","pId":134},{"id":136,"level":4,"name":"新华区","pId":134},{"id":139,"level":4,"name":"长安区","pId":134},{"id":144,"level":-1,"name":"桥西区","pId":134},{"id":145,"level":-1,"name":"唐山市","pId":1},{"id":146,"level":-1,"name":"路南区","pId":145},{"id":147,"level":-1,"name":"路北区","pId":145}]
     * msg :
     * statecode : 0
     * success : true
     */

    private String msg;
    private String statecode;
    private boolean success;
    /**
     * id : 1
     * level : 2
     * name : 河北省
     * pId : 3
     */

    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int id;
        private int level;
        private String name;
        private int pId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPId() {
            return pId;
        }

        public void setPId(int pId) {
            this.pId = pId;
        }
    }
}
