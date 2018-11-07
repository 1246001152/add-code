import { Base } from '../../utils/base.js';

class Msg extends Base {
  constructor() {
    super();
  }

  add(me ,name , callback) {
    var params = {
      url: 'friend/add',
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      type: 'POST',
      data: {
        'me':me,
        'name': name
      },
      sCallback: function (data) {
        callback && callback(data);
      }
    }
    this.request(params);
  }

}

export { Msg };