# alert-agent
An alerting message agent program

alert-agent 是一个报警代理程序，可以做到通过http请求收集报警信息，并通过通过email 或者 企业微信发给给指定的人员。

API 定义访问地址，使用swagger

http://server_address:port/swagger-ui.html


### email 使用
仿照如下post 请求使用
```
curl -X POST --header 'Content-Type: application/json' --header 'Accept: text/plain' -d '{ \
   "message": "报警的具体消息", \
   "subject": "email 的标题", \
   "to": "收件人1;收件人2;收件人3" \
 }' 'http://10.202.6.87:9001/sendMail'
```

### 企业微信使用
仿照如下post 请求使用
```
curl -X POST --header 'Content-Type: application/json' --header 'Accept: text/plain' -d '{ \
   "message": "要发送的报警消息", \
   "toParty": "部门1Id|部门2Id, 目前是全员发送，此参数不起作用", \
   "toUser": "用户1Id|用户2Id, 目前是全员发送，此参数不起作用" \
 }' 'http://10.202.6.87:9001/sendEnterpriseWechat'
```

##### 使用者必须要先加入企业微信
请参考
https://work.weixin.qq.com/api/doc