package ir.vsr;

import java.util.*;

import ir.utilities.*;

/**
 * A data structure for a term vector for a document stored as a HashMap that
 * maps tokens to Weight's that store the weight of that token in the document.
 * <p/>
 * Needed as an efficient, indexed representation of sparse document vectors.
 *
 * @author Ray Mooney
 */

public class HashMapProxVector {
  /**
   * The HashMap that stores the mapping of tokens to Weights
   */
  public Map<String, List<Integer>> hashMap = new HashMap<String, List<Integer>>();

  /**
   * Returns the number of tokens in the vector.
   */
  public int size() {
    return hashMap.size();
  }

  /**
   * Clears the vector back to all zeros
   */
  public void clear() {
    hashMap.clear();
  }

  /**
   * Returns the Set of MapEntries in the hashMap
   */
  public Set<Map.Entry<String, List<Integer>>> entrySet() {
    return hashMap.entrySet();
  }

  /**
   * Increment the weight for the given token in the vector by the given amount.
   */
  public void increment(String token, int pos) {
    List<Integer> positions = hashMap.get(token);
    if (positions == null) {
      // If there is no current Weight for this token, create one
      positions = new ArrayList<Integer>();
      hashMap.put(token, positions);
    }
    // Increment the weight of this token in the bag.
    positions.add(pos);
  }

}
