<?php
namespace App\Model\Table;

use Cake\ORM\Query;
use Cake\ORM\RulesChecker;
use Cake\ORM\Table;
use Cake\Validation\Validator;

/**
 * HistoryNewBirds Model
 *
 * @method \App\Model\Entity\HistoryNewBird get($primaryKey, $options = [])
 * @method \App\Model\Entity\HistoryNewBird newEntity($data = null, array $options = [])
 * @method \App\Model\Entity\HistoryNewBird[] newEntities(array $data, array $options = [])
 * @method \App\Model\Entity\HistoryNewBird|bool save(\Cake\Datasource\EntityInterface $entity, $options = [])
 * @method \App\Model\Entity\HistoryNewBird patchEntity(\Cake\Datasource\EntityInterface $entity, array $data, array $options = [])
 * @method \App\Model\Entity\HistoryNewBird[] patchEntities($entities, array $data, array $options = [])
 * @method \App\Model\Entity\HistoryNewBird findOrCreate($search, callable $callback = null, $options = [])
 */
class HistoryNewBirdsTable extends Table
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

        $this->setTable('history_new_birds');
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

        return $validator;
    }
}
