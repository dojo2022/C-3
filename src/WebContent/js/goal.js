/**
 *
 */
 'use strict';

 $(function() {
  $('.title').click(function() {
    $(this).next('.content').slideToggle();
    $(this).toggleClass("active");
  });
});