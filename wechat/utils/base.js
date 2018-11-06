import { Config } from 'config.js';

class Base {
  constructor() {
    this.baseRequestUrl = Config.baseUrl;
  }

  // 当noRefech为true时，不做未授权重试机制
  request(params, noRefetch) {
    var that = this;
    var url = this.baseRequestUrl + params.url;

    if (!params.type) {
      params.type = 'GET';
    }

    if (!params.header) {
      params.header = {
        'content-type': 'application/json'
      }
    }

    wx.request({
      url: url,
      data: params.data,
      method: params.type,
      header: params.header,
      success: function (res) {
        console.log(res)
        var code = res.statusCode.toString();
        var startChar = code.charAt(0);

        if (startChar == '2') {
          //赋值，无值与有值
          params.sCallback && params.sCallback(res.data);
        }
        else {
          //AOP
          if (code == '401') {
            // token.getTokenFromServer
            // base.request
            if (!noRefetch) {
              that._refetch(params);
            }
          }
          if (noRefetch) {
            params.eCallback && params.eCallback(res.data);
          }
        }
      },
      fail: function (err) {
        console.log(err);
      }
    })
  }

  /*获得元素上的绑定的值*/
  getDataSet(event, key) {
    return event.currentTarget.dataset[key];
  };

}

export { Base };