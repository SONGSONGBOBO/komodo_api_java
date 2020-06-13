package com.songbo.server.bean.rewards;

import lombok.Data;

/**
 * @ClassName RewardsinfoResult
 * @Description TODO
 * {
 *   "result": "success",
 *   "fundingtxid": "e020151cd81647b20aa45a0e6850216ae52d3e895443bbe1ae97dea3ae6767bd",
 *   "name": "FREE",
 *   "sbits": 1162170950,
 *   "APR": "5.00000000",
 *   "minseconds": 86400,
 *   "maxseconds": 864000,
 *   "mindeposit": "10.00000000",
 *   "funding": "1100.00000000",
 *   "locked": "200.00000000"
 * }
 * @Author songbo
 * @Date 19-10-22 上午9:53
 **/
@Data
public class RewardsinfoResult {

    private String result;
    private String fundingtxid;
    private String name;
    private String sbits;
    private String APR;
    private String minseconds;
    private String maxseconds;
    private String mindeposit;
    private String funding;
    private String locked;

}
