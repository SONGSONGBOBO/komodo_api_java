package com.songbo.server.bean;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName reponse
 * @Description TODO 返回的信息
 * @Author songbo
 * @Date 19-9-26 下午2:26
 **/
@Setter
@Getter
@ToString
public class RPCResponse implements Serializable {
    private String result;
    private ErrorResult error;
    private String id;

    public RPCResponse(){}

    public RPCResponse(String result, ErrorResult error, String id) {
        this.result = result;
        this.error = error;
        this.id = id;
    }

    public static void main(String[] args) {
        String s = "{\n" +
                "\"result\":null,\n" +
                "\"error\":{\n" +
                "\"code\":-1,\n" +
                "\"message\":\"createrawtransaction [{\\\"txid\\\":\\\"id\\\",\\\"vout\\\":n},...] {\\\"address\\\":amount,...} ( locktime ) ( expiryheight )\\n\\nCreate a transaction spending the given inputs and sending to the given addresses.\\nReturns hex-encoded raw transaction.\\nNote that the transaction's inputs are not signed, and\\nit is not stored in the wallet or transmitted to the network.\\n\\nArguments:\\n1. \\\"transactions\\\" (string, required) A json array of json objects\\n [\\n {\\n \\\"txid\\\":\\\"id\\\", (string, required) The transaction id\\n \\\"vout\\\":n (numeric, required) The output number\\n \\\"sequence\\\":n (numeric, optional) The sequence number\\n }\\n ,...\\n ]\\n2. \\\"addresses\\\" (string, required) a json object with addresses as keys and amounts as values\\n {\\n \\\"address\\\": x.xxx (numeric, required) The key is the Komodo address, the value is the KMD amount\\n ,...\\n }\\n3. locktime (numeric, optional, default=0) Raw locktime. Non-0 value also locktime-activates inputs\\n4. expiryheight (numeric, optional, default=200) Expiry height of transaction (if Overwinter is active)\\n\\nResult:\\n\\\"transaction\\\" (string) hex string of the transaction\\n\\nExamples\\n> komodo-cli -ac_name=DIC createrawtransaction \\\"[{\\\\\\\"txid\\\\\\\":\\\\\\\"myid\\\\\\\",\\\\\\\"vout\\\\\\\":0}]\\\" \\\"{\\\\\\\"address\\\\\\\":0.01}\\\"\\n> curl --user myusername --data-binary '{\\\"jsonrpc\\\": \\\"1.0\\\", \\\"id\\\":\\\"curltest\\\", \\\"method\\\": \\\"createrawtransaction\\\", \\\"params\\\": [\\\"[{\\\\\\\"txid\\\\\\\":\\\\\\\"myid\\\\\\\",\\\\\\\"vout\\\\\\\":0}]\\\", \\\"{\\\\\\\"address\\\\\\\":0.01}\\\"] }' -H 'content-type: text/plain;' http://127.0.0.1:21331/\\n\"\n" +
                "},\n" +
                "\"id\":1\n" +
                "}";
        JSONObject jsonObject = (JSONObject) JSONObject.parse(s);
        RPCResponse rpcResponse = jsonObject.toJavaObject(RPCResponse.class);
        //RPCResponse rpcResponse = (RPCResponse) JSONObject.parse(s);
        System.out.println(rpcResponse.getId());
    }
}
