import { Base } from '../../utils/base.js';

class Index extends Base {
  constructor() {
    super();
  }

  resgist(name, pass, callback) {
    var params = {
      url: 'user/resgist',
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      type: 'POST',
      data: {
        'name': name,
        'pass': pass
      },
      sCallback: function (data) {
        callback && callback(data);
      }
    }
    this.request(params);
  }

  login(name, pass, callback) {
    var params = {
      url: 'user/login',
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      type: 'POST',
      data: {
        'name': name,
        'pass': pass
      },
      sCallback: function (data) {
        callback && callback(data);
      }
    }
    this.request(params);
  }
}

export { Index };