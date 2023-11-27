package facade;

import java.util.List;
import manager.Manageable;
import manager.Manager;

public abstract class DataEngineImpl<T extends Manageable> extends Manager<T> implements
    IDataEngine<T> {

    String[] labels = null;

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    @Override
    public int getColumnCount() {
        return labels.length;
    }

    // 테이블의 열 제목을 스트링 배열로 돌려줌
    public String[] getColumnNames() {
        return labels;
    }

    @Override
    public void addNewItem(String[] uiTexts) {
        // TODO Auto-generated method stub
    }

    @Override
    public List<T> search(String kwd) {
        if (kwd == null) {
            return mList;
        }
        return findAll(kwd);
    }

    @Override
    public void update(String[] editTexts) {
        // TODO Auto-generated method stub
        Manageable s = find(editTexts[0]);
        ((UIData) s).set(editTexts);
    }

    @Override
    public void remove(String kwd) {
        // TODO Auto-generated method stub
        Manageable s = find(kwd);
        mList.remove(s);
    }

    @Override
    public UIData get(int index) {
        // TODO Auto-generated method stub
        return (UIData) mList.get(index);
    }

    public void addElement(T a) {
        mList.add(a);
    }
}
