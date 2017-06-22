$(function() {
    $('#side-menu').metisMenu();
    
    
    //动态添加菜单
     //addMenu();
    
});

function addMenu(){
	
	 var result="<li>";
	 result+=" <a href=\"#\">";
	 result+="<i class=\"fa fa-bar-chart-o fa-fw\"></i>";
	 result+="管理";
	 result+="<span class=\"fa arrow\"></span>";
	 result+="</a>";
	 
	 result+="<ul class=\"nav nav-second-level collapse\">";
	 result+="		<li>";
	 result+="		    <a href=\"flot.html\">公众号管理</a>";
	 result+="    </li> ";
	 result+="	</ul>  ";
	 
	  result+="</li>";
	    
			
	    

	
	 $('#side-menu').metisMenu('dispose');
	 
	 $("#side-menu li:eq(0)").remove(); //删除第1个
	 
     $("#side-menu").append(result);

     $('#side-menu').metisMenu();
}



//Loads the correct sidebar on window load,
//collapses the sidebar on window resize.
//Sets the min-height of #page-wrapper to window size
$(function() {
	
	
  $(window).bind("load resize", function() {
      var topOffset = 50;
      var width = (this.window.innerWidth > 0) ? this.window.innerWidth : this.screen.width;
      if (width < 768) {
          $('div.navbar-collapse').addClass('collapse');
          topOffset = 100; // 2-row-menu
      } else {
          $('div.navbar-collapse').removeClass('collapse');
      }

      var height = ((this.window.innerHeight > 0) ? this.window.innerHeight : this.screen.height) - 1;
      height = height - topOffset;
      if (height < 1) height = 1;
      if (height > topOffset) {
          $("#page-wrapper").css("min-height", (height) + "px");
      }
  });

  var url = window.location;
  // var element = $('ul.nav a').filter(function() {
  //     return this.href == url;
  // }).addClass('active').parent().parent().addClass('in').parent();
  var element = $('ul.nav a').filter(function() {
      return this.href == url;
  }).addClass('active').parent();

  while (true) {
      if (element.is('li')) {
          element = element.parent().addClass('in').parent();
      } else {
          break;
      }
  }
});
