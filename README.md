# alert-agent
An alerting message agent program

alert-agent 是一个报警代理程序，可以做到通过http请求收集报警信息，并通过通过email 或者 企业微信发给给指定的人员。

API 定义访问地址，使用swagger

http://server_address:port/swagger-ui.html


### email 使用
仿照如下post 请求使用
```
curl -X POST --header 'Content-Type: application/json' --header 'Accept: text/plain' \
-d '报警消息' 'http://10.202.6.87:9001/sendMail?subject=http-mq-agent(10.202.6.86)%E5%8F%91%E7%94%9F%E5%BC%82%E5%B8%B8 \
&toUsers=ac_qianbing%40juran.com.cn%3B20926945%40qq.com'
```

### 企业微信使用
仿照如下post 请求使用
```
curl -X POST --header 'Content-Type: application/json' --header 'Accept: text/plain' \
-d '报警消息' 'http://10.202.6.87:9001/sendEnterpriseWechat?subject=%E5%87%BA%E9%97%AE%E9%A2%98%E4%BA%86 \
&toUsers=qianbing%7Czhulang&toParts=1%7C2'
```

##### 使用者必须要先加入企业微信
请参考
https://work.weixin.qq.com/api/doc