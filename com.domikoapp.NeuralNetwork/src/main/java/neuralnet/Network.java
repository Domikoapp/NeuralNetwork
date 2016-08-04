package neuralnet;

import Jama.Matrix;

/**
 * ニューラルネットワークを表すクラス。<br>
 * @author yutaka.omido
 */
public class Network {

	private int layerNum;
	private int[] layerSizes;
	private Matrix biases;
	private Matrix weights;

	/**
	 * layerNum層からなるニューラルネットワークを生成します。<br>
	 * 各層にいくつのニューロンがあるかはlayerSizesで指定されます。<br>
	 * つまり、layerSizes[i]はi層目のニューロンの数を表します。<br>
	 * 各ニューロンの重み・バイアスは一様乱数で初期化されます。<br>
	 * @param layerNum ネットワークが何層であるか
	 * @param layerSizes 各層に存在するニューロンの数
	 */
	public Network(int layerNum, int[] layerSizes) {
		// 層の数を初期化
		this.layerNum = layerNum;

		// ニューロン数を初期化
		if ((layerSizes == null) || (layerNum != layerSizes.length)) {
			throw new IllegalArgumentException("各層のニューロン数を初期化できません。");
		}
		this.layerSizes = layerSizes;
		
		
	}
}
