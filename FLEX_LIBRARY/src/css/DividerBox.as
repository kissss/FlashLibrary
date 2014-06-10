// ActionScript file
package css
{
	import flash.events.MouseEvent;
	import flash.events.TimerEvent;
	import flash.utils.Timer;

	import mx.containers.Box;
	import mx.containers.DividedBox;
	import mx.controls.Image;
	import mx.effects.Resize;
	import mx.effects.easing.Bounce;

	public class DividerBox extends Box
	{
		[Embed(source='../images/left.png')]
		public static const DividerIcon_left:Class;

		[Embed(source='../images/right.png')]
		public static const DividerIcon_right:Class;
		private var image:Image=new Image();
		private var bOpened:Boolean=true;
		private var dividbox:DividedBox=null;
		private var timer:Timer;

		public function DividerBox()
		{
			super();
			this.width=0;
			this.height=16;
			this.clipContent=false;
			image.width=16;
			image.height=16;
			this.addChild(image);

			//我这个是在一个HdividedBox中，其默认对dividerbox进行了旋转，所以需要旋转回来。      
			image.rotation=90;
			image.addEventListener(MouseEvent.CLICK, onMouseClick);

		}

		override protected function createChildren():void
		{
			super.createChildren();
			dividbox=this.parent.parent.parent as DividedBox;
			image.source=DividerIcon_left;
		}

		private var left_width:int=200;
		private var resize:Resize=new Resize();

		public function onMouseClick(event:MouseEvent):void
		{
			resize.easingFunction=Bounce.easeOut;
			if (bOpened)
			{
				var array1:Array=new Array();
				array1.push(dividbox.getChildAt(0));
				image.source=DividerIcon_right;
				resize.duration=500;
				resize.widthFrom=left_width;
				resize.widthTo=0;
				resize.play(array1);
				bOpened=false;
			}
			else
			{
				image.source=DividerIcon_left;
				var array2:Array=new Array();
				array2.push(dividbox.getChildAt(0));
				resize.duration=500;
				image.source=DividerIcon_left;
				resize.widthFrom=0;
				resize.widthTo=left_width;
				resize.play(array2);
				dividbox.getChildAt(0).width=left_width;
				bOpened=true;
			}
		}

	}
}
