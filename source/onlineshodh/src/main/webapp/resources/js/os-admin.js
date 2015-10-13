/*=============================================================

   
========================================================  */           

$(document).ready(function () {

    /*====================================
           METIS MENU 
     ======================================*/

    $('#main-menu').metisMenu();

    /*======================================
    LOAD APPROPRIATE MENU BAR ON SIZE SCREEN
    ========================================*/

    $(window).bind("load resize", function () {
        if ($(this).width() < 768) {
            $('div.sidebar-collapse').addClass('collapse')
        } else {
            $('div.sidebar-collapse').removeClass('collapse')
        }
    });
 
       
    /*======================================
         PAGE LODING SCRIPT USING AJAX
    ========================================*/
    $(".nav-second-level a").on('click', function(e) {
        e.preventDefault();
        var page = $(this).attr('href');
        $('#page-inner').load(page);
         $(".nav-second-level a").removeClass("active-menu");
         $(".nav-second-level").removeClass("in");
        $(this).addClass("active-menu");
    });
    
    /*======================================
    PAGE LODING SCRIPT FOR EDIT PAGE USING AJAX
========================================*/
  
    $(".edit").on('click', function(e) {
        e.preventDefault();
        var page = $(this).attr('href');
        $('#page-inner').load(page);
       
    });
    
    
    $(".back").on('click', function(e) {
    	console.log(e)
        e.preventDefault();
        var page = $(this).attr('href');
        $('#page-inner').load(page);
        history.pushState({profile:profile_info}, "profile", profile_url);
       
    });
 
    
});
      