import { Home } from 'home-model.js';
var home = new Home();
// pages/home/home.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    name:'',
    list:[]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options);
    this.setData({
      name: options.name
    })
    home.getMyFriend(options.name,(res)=>{
      this.setData({
        list:res.data
      })
    })
  },

  tapCode:function(e){
    wx.redirectTo({
      url: '../code/code?name='+this.data.name,
    })
  },

  tapAdd:function(e){
    var that = this;
    wx.scanCode({
      // onlyFromCamera:true,
      success(res){
        console.log(res)
        wx.redirectTo({
          url: '../msg/msg?name='+res.result+'&me='+that.data.name,
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})