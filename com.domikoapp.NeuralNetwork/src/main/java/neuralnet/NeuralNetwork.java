package neuralnet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Jama.Matrix;

/**
 * ニューラルネットワークを表すクラス。<br>
 *
 * @author domiko
 */
public class NeuralNetwork {

	/** このニューラルネットワークには層がいくつあるか */
	private int layerNum;

	/** 各層にはいくつのニューロンがあるか */
	private int[] layerSizes;

	/**
	 * 重みを保存する行列。<br>
	 * i番目の要素はi層目から(i+1)層目への重みである。
	 */
	private List<Matrix> weights = new ArrayList<Matrix>();

	/**
	 * 閾値を保存する行列。<br>
	 * i番目の要素は(i+1)層目の閾値である。
	 */
	private List<Matrix> bases = new ArrayList<Matrix>();

	/**
	 * 新たなニューラルネットワークを生成します。<br>
	 * @param layerNum 何層のネットワークを生成するか
	 * @param layerSizes 各層にいくつのニューロンを生成するか
	 */
	public NeuralNetwork (int layerNum, int[] layerSizes) {
		// 少なくとも入力層と出力層が必要
		if (layerNum < 2) {
			throw new IllegalArgumentException("ニューラルネットワークには少なくとも入力層と出力層の2層が必要です。");
		}

		// 各層のニューロン生成数を表す配列のサイズが、layerNumと一致している必要がある
		if (layerNum != layerSizes.length) {
			throw new IllegalArgumentException("生成する層の数と、各層のニューロンを指定する配列のサイズは等しくなる必要があります。");
		}

		// 各層には少なくとも1つのニューロンが必要
		for (int size : layerSizes) {
			if (size < 1) {
				throw new IllegalArgumentException("生成するニューロンの数は、どの層も最低1つ以上である必要があります。");
			}
		}

		// ニューラルネットワークを初期化する
		// 重みと閾値は簡単のため、0-1の一様乱数で初期化する
		this.layerNum = layerNum;
		this.layerSizes = layerSizes;

		for (int layer = 0; layer < (layerNum-1); layer++) {
			Matrix weight = new Matrix(layerSizes[layer+1], layerSizes[layer]);
			this.initializeMatrixWithRandomValue(weight);
			this.weights.add(weight);
		}

		for (int layer = 1; layer < layerNum; layer++) {
			Matrix base = new Matrix(layerSizes[layer], 1);
			this.initializeMatrixWithRandomValue(base);
			this.bases.add(base);
		}
	}

	/**
	 * 与えられた行列の各要素を一様乱数で初期化する
	 * @param matrix 初期化する行列
	 */
	private void initializeMatrixWithRandomValue(Matrix matrix) {
		Random random = new Random();
		for (int i=0; i<matrix.getRowDimension(); i++) {
			for (int j=0; j<matrix.getColumnDimension(); j++) {
				matrix.set(i, j, random.nextDouble());
			}
		}
	}


	public static void main(String[] args) {

	}
}
