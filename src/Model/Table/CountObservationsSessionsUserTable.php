<?php
namespace App\Model\Table;

use Cake\ORM\Query;
use Cake\ORM\RulesChecker;
use Cake\ORM\Table;
use Cake\Validation\Validator;

/**
 * CountObservationsSessionsUser Model
 *
 * @method \App\Model\Entity\CountObservationsSessionsUser get($primaryKey, $options = [])
 * @method \App\Model\Entity\CountObservationsSessionsUser newEntity($data = null, array $options = [])
 * @method \App\Model\Entity\CountObservationsSessionsUser[] newEntities(array $data, array $options = [])
 * @method \App\Model\Entity\CountObservationsSessionsUser|bool save(\Cake\Datasource\EntityInterface $entity, $options = [])
 * @method \App\Model\Entity\CountObservationsSessionsUser patchEntity(\Cake\Datasource\EntityInterface $entity, array $data, array $options = [])
 * @method \App\Model\Entity\CountObservationsSessionsUser[] patchEntities($entities, array $data, array $options = [])
 * @method \App\Model\Entity\CountObservationsSessionsUser findOrCreate($search, callable $callback = null, $options = [])
 */
class CountObservationsSessionsUserTable extends Table
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

        $this->setTable('count_observations_sessions_user');
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
            ->integer('Sessions_ID')
            ->requirePresence('Sessions_ID', 'create')
            ->notEmpty('Sessions_ID');

        $validator
            ->integer('User_ID')
            ->requirePresence('User_ID', 'create')
            ->notEmpty('User_ID');

        return $validator;
    }
}
