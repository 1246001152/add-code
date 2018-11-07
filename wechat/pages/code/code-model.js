import { Base } from '../../utils/base.js';

class Code extends Base {
  constructor() {
    super();
  }

  code(name, callback) {
    var params = {
      url: 'friend/code',
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      type: 'POST',
      data: {
        'name': name
      },
      sCallback: function (data) {
        callback && callback(data);
      }
    }
    this.request(params);
  }

}

export { Code };