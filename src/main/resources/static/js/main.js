/*********************************************************************************

	Template Name: Genrre - Fashion eCommerce Bootstrap4 Template
	Description: A perfect template to build beautiful and unique fashion eCommerce websites. It comes with nice and clean design.
	Version: 1.0

	Note: This is main js.

**********************************************************************************/

/**************************************************************
	
	STYLESHEET INDEXING
	|
	|
	|___ Sticky Header
	|___ Hero Area Slider Active
	|___ Gallery Blog Slider Active
	|___ Brand Logo Slider Active
	|___ Similliar Products Slider Active
	|___ Product Details Images
	|___ Nice Select Activation
	|___ Banner Masonry Activaiton
	|___ Bootstrap4 Tooltip Active
	|___ Mobile Menu
	|___ Shop Product View Toogler 
	|___ Product Quantity 
	|___ Product Detals Color & Size 
	|___ Product Popup
	|___ Quick View Modal
	|___ Rating Hover Action
	|___ Range Slider Active
	|___ Tags Cloud
	|___ Progress Bar Effect 
	|___ Checkout Login Coupon 
	|___ Different Address Form 
	|
	|
	|___ END STYLESHEET INDEXING

***************************************************************/


(function($){
    'use strict';
	


	/* Sticky Header */
	$(window).on('scroll', function () {
		var scrollPos = $(this).scrollTop();
		if (scrollPos > 300) {
			$('.sticky-header').addClass('is-sticky');
		} else {
			$('.sticky-header').removeClass('is-sticky');
		}
	});




	/* Hero Area Slider Active */
	$('.hero-area').slick({
		slidesToShow: 1,
		autoplay: true,
		autoplaySpeed: 8000,
		adaptiveHeight: true,
		dots: false,
		arrows: true,
		fade: true,
		easing: 'ease-in-out',
		speed: 1000,
		prevArrow: '<span class="slider-navigation slider-navigation-prev"><i class="fa fa-angle-left"></i></span>',
		nextArrow: '<span class="slider-navigation slider-navigation-next"><i class="fa fa-angle-right"></i></span>',
	});


	
	/* Gallery Blog Slider Active */
	$('.blog-item-gallery').slick({
		slidesToShow: 1,
		autoplay: true,
		autoplaySpeed: 8000,
		adaptiveHeight: true,
		dots: false,
		arrows: true,
		fade: true,
		easing: 'ease-in-out',
		speed: 1000,
		prevArrow: '<span class="slider-navigation slider-navigation-prev"><i class="fa fa-angle-left"></i></span>',
		nextArrow: '<span class="slider-navigation slider-navigation-next"><i class="fa fa-angle-right"></i></span>',
	});
	


	/* Brand Logo Slider Active */
	$('.brand-logos').slick({
		slidesToShow: 4,
		autoplay: true,
		autoplaySpeed: 5000,
		dots: false,
		arrows: true,
		easing: 'ease-in-out',
		prevArrow: '<span class="slider-navigation slider-navigation-prev"><i class="fa fa-caret-left"></i></span>',
		nextArrow: '<span class="slider-navigation slider-navigation-next"><i class="fa fa-caret-right"></i></span>',
		responsive: [{
			breakpoint: 992,
			settings: {
				slidesToShow: 3,
				slidesToScroll: 1
			}
		},
		{
			breakpoint: 768,
			settings: {
				slidesToShow: 2,
				slidesToScroll: 1
			}
		},
		{
			breakpoint: 450,
			settings: {
				slidesToShow: 1,
				slidesToScroll: 1
			}
		}]
	});


	/* Similliar Products Slider Active */
	$('.similliar-products-slider-active').slick({
		slidesToShow: 4,
		autoplay: true,
		autoplaySpeed: 5000,
		dots: false,
		arrows: true,
		easing: 'ease-in-out',
		prevArrow: '<span class="slider-navigation slider-navigation-prev"><i class="fa fa-caret-left"></i></span>',
		nextArrow: '<span class="slider-navigation slider-navigation-next"><i class="fa fa-caret-right"></i></span>',
		responsive: [{
			breakpoint: 1200,
			settings: {
				slidesToShow: 3,
				slidesToScroll: 1
			}
		},
		{
			breakpoint: 992,
			settings: {
				slidesToShow: 2,
				slidesToScroll: 1
			}
		},
		{
			breakpoint: 576,
			settings: {
				slidesToShow: 1,
				slidesToScroll: 1
			}
		}]
	});



	/* Product Details Images */
	$('.product-details-images').slick({
		slidesToShow: 1,
		slidesToScroll: 1,
		autoplay: true,
		autoplaySpeed: 5000,
		dots: false,
		infinite: true,
		centerMode: true,
		centerPadding: 0,
		prevArrow: '<span class="slider-navigation slider-navigation-prev"><i class="fa fa-caret-left"></i></span>',
		nextArrow: '<span class="slider-navigation slider-navigation-next"><i class="fa fa-caret-right"></i></span>',
		asNavFor: '.product-details-thumbs'
	});
	$('.product-details-thumbs').slick({
		slidesToShow: 3,
		slidesToScroll: 1,
		autoplay: true,
		autoplaySpeed: 5000,
		dots: false,
		infinite: true,
		focusOnSelect: true,
		centerMode: true,
		centerPadding: 0,
		prevArrow: '<span class="slider-navigation slider-navigation-prev"><i class="fa fa-caret-left"></i></span>',
		nextArrow: '<span class="slider-navigation slider-navigation-next"><i class="fa fa-caret-right"></i></span>',
		asNavFor: '.product-details-images'
	});






	/* Nice Select Activation */
	$('select').niceSelect();
	




	/* Banner Masonry Activaiton */
	$('.banners-masonry-active').imagesLoaded( function() {

		$('.banners-masonry-active').masonry({
			itemSelector: '.masonry-item',
			columnWidth: 1
		});
 
	});


	

	/* Bootstrap4 Tooltip Active */
	$('[data-toggle="tooltip"]').tooltip();


	

	/* Mobile Menu */
	$('nav.sn-navigation').meanmenu({
		meanMenuClose: '<img src="img/icons/icon-close.png" alt="close icon">',
		meanMenuCloseSize: '18px',
		meanScreenWidth: '991',
		meanExpandableChildren: true,
		meanMenuContainer: '.mobile-menu',
		onePage: true
	});




	/* Shop Product View Toogler */
	$('.shop-toolbar-changeview button').on('click', function(){

		if( $(this).data('product-view') == 'list' ){
			$('.shop-toolbar-changeview button[data-product-view="list"]').addClass('active').siblings().removeClass('active');
			$('.shop-page-products').addClass('active-list-view').removeClass('active-grid-view');
		} else{
			$('.shop-toolbar-changeview button[data-product-view="grid"]').addClass('active').siblings().removeClass('active');
			$('.shop-page-products').addClass('active-grid-view').removeClass('active-list-view');
		}

	});




	/* Product Quantity */
	$('.quantity-select').append('<div class="dec qtybutton">-</i></div><div class="inc qtybutton">+</div>');
    $('.qtybutton').on('click', function () {
        var $button = $(this);
		var oldValue = $button.parent().find('input').val();
		var newVal;
        if ($button.text() == "+") {
            newVal = parseFloat(oldValue) + 1;
        } else {
            if (oldValue > 1) {
                newVal = parseFloat(oldValue) - 1;
            } else {
                newVal = 1;
            }
        }
        $button.parent().find('input').val(newVal);
	});
	



	/* Product Detals Color & Size */
	$('.product-details-color ul li, .product-details-size ul li').on('click', function(){
		$(this).addClass('checked').siblings().removeClass('checked');
	});




	/* Product Popup */
	$('.product-details-images').magnificPopup({
		type:'image',
		delegate: 'a',
		gallery:{
			enabled:true
		}
	});




	/* Quick View Modal */
	$('.quick-view-trigger').on('click', function(e){
		e.preventDefault();
		$('.quick-view-modal').toggleClass('is-visible');
	});
	$('.close-quickview-modal').on('click', function(){
		$('.quick-view-modal').removeClass('is-visible');
	});




	/* Rating Hover Action */
	$('.ratting-box.hover-action span').on('mouseenter', function(){
		$('.ratting-box.hover-action span').addClass('active');
		$(this).nextAll('span').removeClass('active');
	});




	/* Range Slider Active */
	$('.range-slider').nstSlider({
		'left_grip_selector': '.range-slider-leftgrip',
		'right_grip_selector': '.range-slider-rightgrip',
		'value_bar_selector': '.bar',
		'value_changed_callback': function(cause, leftValue, rightValue) {
			$(this).parent().find('.range-slider-leftlabel').text(leftValue);
			$(this).parent().find('.range-slider-rightlabel').text(rightValue);
		}
	});





	/* Tags Cloud */
	$('.tagscloud a').tagcloud({
		size: {start: 12, end: 32, unit: "px"},
	});




	/* Tags Cloud */
	$.scrollUp({
		scrollText: '<i class="fa fa-angle-up"></i>',
		easingType: 'linear',
		scrollSpeed: 900,
	});



	/* Progress Bar Effect */
	$(window).on('scroll', function () {

		function winScrollPosition() {
			var scrollPos = $(window).scrollTop(),
				winHeight = $(window).height();
			var scrollPosition = Math.round(scrollPos + (winHeight / 1.2));
			return scrollPosition;
		}


		var trigger = $('.progress-bar');
		if (trigger.length) {
			var triggerPos = Math.round(trigger.offset().top);
			if (triggerPos < winScrollPosition()) {
				trigger.each(function () {
					$(this).addClass('fill');
				});
			}
		}

	});



	/* Checkout Login Coupon */
	$('.checkout-info-collapsebox').css('display', 'none');
	$('.checkout-info-login-trigger, .checkout-info-coupon-trigger').on('click', function(e){
		e.preventDefault();
		$(this).parent('.checkout-info').next('.checkout-info-collapsebox').slideToggle();
	});


	
	/* Different Address Form */
	$('.different-address-form-trigger .sn-checkbox').on('change', function(){
		if( $(this).is(':checked') ){
			$('.different-address-form').slideDown();
		} else{
			$('.different-address-form').slideUp();
		}
	});


})(jQuery);
