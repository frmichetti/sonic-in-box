package br.com.codecode.sonicinbox.enumeration;

public enum SonicIndex {

	STOP(0, 0),WAIT(0, 12),LOOK(13, 14),LOOKING(14, 14),DOWN(15, 16),DOWNED(16, 16),BREAKUP(173, 175),PUSH(197, 200),
	WALK(17, 24),RUN(25, 28),JUMP(),SPIN(41, 45),DASH(46, 51),TRANSFORM(206, 210);

	private int init;

	private int end;

	private SonicIndex(int init, int end) {
		this.init = init;
		this.end = end;
	}

	private SonicIndex() {
		this.init = 0;
		this.end = 0;
	}


	public int getInit() {
		return init;
	}


	public int getEnd() {
		return end;
	}





}
