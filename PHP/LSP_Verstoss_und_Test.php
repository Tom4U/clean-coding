<?php
// Verletzung des LSP
class Rectangle {

	private $topLeft;
	private $width;
	private $height;

	public function setHeight($height) {
		$this->height = $height;
	}

	public function getHeight() {
		return $this->height;
	}

	public function setWidth($width) {
		$this->width = $width;
	}

	public function getWidth() {
		return $this->width;
	}
	
	function area() {
		return $this->width * $this->height;
	}
}

// Das wäre möglich
class Square extends Rectangle {

	public function setHeight($value) {
		$this->width = $value;
		$this->height = $value;
	}

	public function setWidth($value) {
		$this->width = $value;
		$this->height = $value;
	}
}

// Client Code
class Client {

	function areaVerifier(Rectangle $r) {
		$r->setWidth(5);
		$r->setHeight(4);

		if($r->area() != 20) {
			throw new Exception('Bad area!');
		}

		return true;
	}
}

// So kann getestet werden
class LspTest extends PHPUnit_Framework_TestCase {

	function testRectangleArea() {
		$r = new Rectangle();
		$c = new Client();
		$this->assertTrue($c->areaVerifier($r));
	}
	
	function testSquareArea() {
		$r = new Square();
		$c = new Client();
		$this->assertTrue($c->areaVerifier($r));
	}
}