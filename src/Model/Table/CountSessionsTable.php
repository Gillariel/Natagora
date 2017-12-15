<?php
namespace App\Model\Table;

use Cake\ORM\Query;
use Cake\ORM\RulesChecker;
use Cake\ORM\Table;
use Cake\Validation\Validator;

/**
 * CountSessions Model
 *
 * @method \App\Model\Entity\CountSession get($primaryKey, $options = [])
 * @method \App\Model\Entity\CountSession newEntity($data = null, array $options = [])
 * @method \App\Model\Entity\CountSession[] newEntities(array $data, array $options = [])
 * @method \App\Model\Entity\CountSession|bool save(\Cake\Datasource\EntityInterface $entity, $options = [])
 * @method \App\Model\Entity\CountSession patchEntity(\Cake\Datasource\EntityInterface $entity, array $data, array $options = [])
 * @method \App\Model\Entity\CountSession[] patchEntities($entities, array $data, array $options = [])
 * @method \App\Model\Entity\CountSession findOrCreate($search, callable $callback = null, $options = [])
 */
class CountSessionsTable extends Table
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

        $this->setTable('count_sessions');
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

        return $validator;
    }
}
