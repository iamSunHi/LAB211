/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoryCacheManagement;

import java.util.Date;

/**
 *
 * @author Nhật Huy
 */
public class FuCached {
    private Object datas;
    private Date expiredDate;

    public FuCached() {
        
    }

    @Override
    public String toString() {
        String data = "";
        String[] strings = (String[]) this.datas;
        for (String s : strings) {
            data += s + ", ";
        }
        return "FuCached{" + "datas = {" + data + "}, expiredDate = " + this.expiredDate + '}';
    }

    public FuCached(Object datas, Date expiredDate) {
        this.datas = datas;
        this.expiredDate = expiredDate;
    }

    public Object getDatas() {
        return datas;
    }

    public void setDatas(Object datas) {
        this.datas = datas;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }
}
