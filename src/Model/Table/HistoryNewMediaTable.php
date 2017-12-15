<?php
namespace App\Model\Table;

use Cake\ORM\Query;
use Cake\ORM\RulesChecker;
use Cake\ORM\Table;
use Cake\Validation\Validator;

/**
 * HistoryNewMedia Model
 *
 * @method \App\Model\Entity\HistoryNewMedia get($primaryKey, $options = [])
 * @method \App\Model\Entity\HistoryNewMedia newEntity($data = null, array $options = [])
 * @method \App\Model\Entity\HistoryNewMedia[] newEntities(array $data, array $options = [])
 * @method \App\Model\Entity\HistoryNewMedia|bool save(\Cake\Datasource\EntityInterface $entity, $options = [])
 * @method \App\Model\Entity\HistoryNewMedia patchEntity(\Cake\Datasource\EntityInterface $entity, array $data, array $options = [])
 * @method \App\Model\Entity\HistoryNewMedia[] patchEntities($entities, array $data, array $options = [])
 * @method \App\Model\Entity\HistoryNewMedia findOrCreate($search, callable $callback = null, $options = [])
 */
class HistoryNewMediaTable extends Table
{

    /**
     * Initialize method
     *
     * @param array $config The configuration for the Table.
     * @return void
     */
    public function initialize(array $config)
    {
        parent::initialize($config);

        $this->setTable('history_new_media');
    }

    /**
     * Default validation rules.
     *
     * @param \Cake\Validation\Validator $validator Validator instance.
     * @return \Cake\Validation\Validator
     */
    public function validationDefault(Validator $validator)
    {
        $validator
            ->requirePresence('Number', 'create')
            ->notEmpty('Number');

        $validator
            ->scalar('Month')
            ->maxLength('Month', 9)
            ->allowEmpty('Month');

        $validator
            ->dateTime('Creation_Date')
            ->requirePresence('Creation_Date', 'create')
            ->notEmpty('Creation_Date');

        $validator
            ->requirePresence('Has_Been_Pended', 'create')
            ->notEmpty('Has_Been_Pended');

        return $validator;
    }
}
