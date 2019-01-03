var menu_state={
	create: function(){
		
		var space_key = this.game.input.keyboard.addKey(Phaser.Keyboard.SPACEBAR);		//定义接受按键消息变量
		space_key.onDown.add(this.start,this);		//按键按下时调用start()函数
		
		var style = {font: "30px Arial",fill: "#FFFFFF"};		//定义游戏操作说明文字风格
		var x = game.world.width/2,y = game.world.height/2;		//定义坐标变量x,y，(x,y)为game.world中心
		
		this.bg = this.game.add.sprite(0,0,'bg');		//在game.world中坐标(0,0)处画出预加载游戏资源，背景图片

		this.menu = this.game.add.sprite(0,0,'menu');		//加载menu图片
		this.bird = this.game.add.sprite(x-30,y-60,'bird');		//载入即将闯荡管子世界的Bird
		


		  
	},
	start:function(){
		this.game.state.start('play');		//调用start()函数后进入'ready'state
	}
};