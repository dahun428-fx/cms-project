<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<input type="date" max="9999-12-31" />
	<h3>Input</h3>
<div class="ui calendar" id="example1">
  <div class="ui input left icon">
    <i class="calendar icon"></i>
    <input type="text" placeholder="Date/Time" id="input-on">
  </div>
</div>

<input type="text" id="datePicker" class="form-control" value="2019-06-27">


</div>
<script type="text/javascript">

$(function(){
	$('#input-on').keyup(function(){
		console.log($(this).val())
	});
	
	$('#example1').calendar({
			type : 'month',
			startMode : 'month',
			formatter: {
				date: function (date, settings) {
					if (!date) return '';
					let month = (date.getMonth() + 1) + '', year = date.getFullYear();
					if (month.length < 2) month = '0' + month;
					return year + '.' + month;
				}
			}

		});
	})
</script>
