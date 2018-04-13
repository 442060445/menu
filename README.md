# menu
# API

###商品列表
```
GET /sell/buyer/product/list
```
参数
```
无
```
返回
```
{
    "code": 0,
    "msg": "成功",
    "data": [
        {
            "name": "推荐",
            "type": 1,
            "foods": [
                {
                    "id": "000012",
                    "name": "澳洲牛扒",
                    "price": 68,
                    "description": "这是一份澳洲牛扒",
                    "icon": "http://192.168.56.102:8877/images/niupa.jpg",
                }
                ｛
                    "id": "000013",
                    "name": "意大利黑椒牛扒",
                    "price": 56,
                    "description": "这是一份意大利黑椒牛扒",
                    "icon": "http://192.168.56.102:8877/images/niupa.jpg",
                ｝
            ]
        },
        {
            "name": "热卖",
            "type": 2,
            "foods": [
                {
                    "id": "123456",
                    "name": "皮蛋粥",
                    "price": 5.5,
                    "description": "这是一碗皮蛋粥",
                    "icon": "http://192.168.56.102:8877/images/pidanzhou.jpg",
                }
            ]
        }
        {
            "name": "主食",
            "type": 3,
            "foods": [
                {
                    "id": "000002",
                    "name": "米饭",
                    "price": 1,
                    "description": "这是一碗米饭",
                    "icon": "http://192.168.56.102:8877/images/mifan.jpg",
                }
            ]
        }
    ]
}
```


###创建订单
```
POST /sell/buyer/order/create
```
参数
```
name: "顾客注册测试1"//用户姓名
userId: "152353020857181050"//用户ID
phone: "13798957775"//用户手机
desknum: "10" //桌号
items: [//商品列表
    {   
        productId:"123456",
        productQuantity:3
    },
    {   
        productId:"000001",
        productQuantity:1
    },
    {   
        productId:"000002",
        productQuantity:2
    }
]

```
返回
```
{
  "code": 0,
  "msg": "成功",
  "data": {
      "orderId": "1523611023729531562" 
  }
}


```
###查询订单列表
```
GET /sell/buyer/order/list
```
参数
```
userId: 152353020857181050
page: 0 //从第0页开始
size: 10//每页10项
```
返回
```
{
    "code": 0,
    "msg": "成功",
    "data": [
        {
            "orderId": "1523611023729531562",
            "username": "顾客注册测试1",
            "userId": "152353020857181050",
            "desknum": "10",
            "orderAmount": 33.5,
            "orderStatus": 0,
            "payStatus": 0,
            "createTime": 1523611022,
            "updateTime": 1523611022
        }
    ]
}


```
###查询订单详情
```
GET /sell/buyer/order/detail
```
参数
```
userId: 152353020857181050
orderId: 1523611023729531562
```
返回
```
{
    "code": 0,
    "msg": "成功",
    "data": {
        "orderId": "1523611023729531562",
        "username": "顾客注册测试1",
        "userId": "152353020857181050",
        "desknum": "10",
        "orderAmount": 33.5,
        "orderStatus": 0,
        "payStatus": 0,
        "createTime": 1523611022,
        "updateTime": 1523611022,
        "orderDetailList": [
            {
                "detailId": "1523611023730198373",
                "orderId": "1523611023729531562",
                "productId": "123456",
                "productName": "皮蛋粥",
                "productPrice": 5.5,
                "productQuantity": 3,
                "productIcon": "http://192.168.56.102:8877/images/pidanzhou.jpg",
                "createTime": 1516697269000,
                "updateTime": 1523609300000
            },
            {
                "detailId": "1523611023732273719",
                "orderId": "1523611023729531562",
                "productId": "000001",
                "productName": "牛肉套餐",
                "productPrice": 15,
                "productQuantity": 1,
                "productIcon": "http://192.168.56.102:8877/images/2.jpg",
                "createTime": 1516697333000,
                "updateTime": 1523604969000
            },
            {
                "detailId": "1523611023734751578",
                "orderId": "1523611023729531562",
                "productId": "000002",
                "productName": "米饭",
                "productPrice": 1,
                "productQuantity": 2,
                "productIcon": "http://192.168.56.102:8877/images/mifan.jpg",
                "createTime": 1516697444000,
                "updateTime": 1523609300000
            }
        ]
    }
}
```


###取消订单
```
GET /sell/buyer/order/cancel
```
参数
```
userId: 152353020857181050
orderId: 1523611023729531562
```
返回
```
{
    "code": 0,
    "msg": "成功"
}
```

###创建评价
```
POST /sell/buyer/evaluate/create
```
参数
```
userId: 152353020857181050
username：顾客注册测试1
rating: 1523611023729531562
content：5星好评
```
返回
```
{
    "code": 0,
    "msg": "成功",
    "data": {
        "UserId": "152353020857181050"
    }
}
```


###评价记录
```
GET /sell/buyer/evaluate/list
```
参数
```
userId: 152353020857181050
```
返回
```
{
    "code": 0,
    "msg": "成功",
    "data": [
        {
            "evaluateId": "1523612266863463085",
            "userId": "152353020857181050",
            "username": "顾客注册测试1",
            "rating": 5,
            "content": "5星好评",
            "createTime": 1523612265,
            "updateTime": 1523612265
        }
    ]
}
```

