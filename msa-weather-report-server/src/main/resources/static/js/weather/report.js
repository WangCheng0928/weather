/**
 * @Author: wangcheng
 * report頁面下拉框事件
 * @Date: 17:39 2018/6/7
 */
$(function () {
   $("#selectCityId").change(function () {
       var cityId = $("#selectCityId").val();
       var url = '/report/cityId/' + cityId;
       window.location.href = url;
   })
});