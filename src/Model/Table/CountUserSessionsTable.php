<?php
namespace App\Model\Table;

use Cake\ORM\Query;
use Cake\ORM\RulesChecker;
use Cake\ORM\Table;
use Cake\Validation\Validator;

/**
 * CountUserSessions Model
 *
 * @method \App\Model\Entity\CountUserSession get($primaryKey, $options = [])
 * @method \App\Model\Entity\CountUserSession newEntity($data = null, array $options = [])
 * @method \App\Model\Entity\CountUserSession[] newEntities(array $data, array $options = [])
 * @method \App\Model\Entity\CountUserSession|bool save(\Cake\Datasource\EntityInterface $entity, $options = [])
 * @method \App\Model\Entity\CountUserSession patchEntity(\Cake\Datasource\EntityInterface $entity, array $data, array $options = [])
 * @method \App\Model\Entity\CountUserSession[] patchEntities($entities, array $data, array $options = [])
 * @method \App\Model\Entity\CountUserSession findOrCreate($search, callable $callback = null, $options = [])
 */
class CountUserSessionsTable extends Table
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

        $this->setTable('count_user_sessions');
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
            ->integer('User_ID')
            ->requirePresence('User_ID', 'create')
            ->notEmpty('User_ID');

        return $validator;
    }
}
