<?php
namespace App\Test\TestCase\Model\Table;

use App\Model\Table\Top5BirdTable;
use Cake\ORM\TableRegistry;
use Cake\TestSuite\TestCase;

/**
 * App\Model\Table\Top5BirdTable Test Case
 */
class Top5BirdTableTest extends TestCase
{

    /**
     * Test subject
     *
     * @var \App\Model\Table\Top5BirdTable
     */
    public $Top5Bird;

    /**
     * Fixtures
     *
     * @var array
     */
    public $fixtures = [
        'app.top5_bird'
    ];

    /**
     * setUp method
     *
     * @return void
     */
    public function setUp()
    {
        parent::setUp();
        $config = TableRegistry::exists('Top5Bird') ? [] : ['className' => Top5BirdTable::class];
        $this->Top5Bird = TableRegistry::get('Top5Bird', $config);
    }

    /**
     * tearDown method
     *
     * @return void
     */
    public function tearDown()
    {
        unset($this->Top5Bird);

        parent::tearDown();
    }

    /**
     * Test initialize method
     *
     * @return void
     */
    public function testInitialize()
    {
        $this->markTestIncomplete('Not implemented yet.');
    }

    /**
     * Test validationDefault method
     *
     * @return void
     */
    public function testValidationDefault()
    {
        $this->markTestIncomplete('Not implemented yet.');
    }
}
