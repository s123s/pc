$(document).ready(function(){
	
	$('.item .delete').click(function(){
		
		var elem = $(this).closest('.item');
		
		$.confirm({
			'title'		: /*'Delete Confirmation'*/'Удаление принтера',
			'message'	: /*'You are about to delete this item. <br />It cannot be restored at a later time! Continue?',*/
				'Вы уверены что хотите удалить этот принтер.<br /> Вы не сможете восстановить его позже. Продолжить?',
			'buttons'	: {
				/*'Yes'*/'Да'	: {
					'class'	: 'blue',
					'action': function(){
                        document.delete13.submit()
						/*elem.slideUp();*/
					}
				},
				/*'No'*/'Нет'	: {
					'class'	: 'gray',
					'action': function(){}	// Nothing to do in this case. You can as well omit the action property.
				}
			}
		});
		
	});
	
});